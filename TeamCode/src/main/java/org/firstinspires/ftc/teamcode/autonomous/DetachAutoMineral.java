package org.firstinspires.ftc.teamcode.autonomous;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.vuforia.CameraDevice;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.teamcode.hardware.LinearActuator;
import org.firstinspires.ftc.teamcode.hardware.hardwareutils.HardwareManager;

import java.util.List;


@Autonomous
public class DetachAutoMineral extends LinearOpMode {

    private String loggingName = "MineralRecognition";

    HardwareManager hardware;

    // drive train motors
    DcMotor leftFrontDrive;
    DcMotor leftRearDrive;
    DcMotor rightFrontDrive;
    DcMotor rightRearDrive;

    // Elevator Linear Actuators
    LinearActuator leftActuator;
    LinearActuator rightActuator;

    CRServo latch;

    // vision
    private AutoCommands commands;
    private final int TARGET_NOT_DETECTED = -1;
    /**
     * {@link #vuforia} is the variable we will use to store our instance of the
     * Vuforia localization engine.
     */
    private VuforiaLocalizer vuforia;
    private boolean isDone = false;
    private final long TIME_TO_MOVE_FORWARD = 0400;
    /**
     * {@link #tfod} is the variable we will use to store our instance of the Tensor
     * Flow Object Detection engine.
     */
    private TFObjectDetector tfod;

    @Override
    public void runOpMode() {
        initVuforia();
        hardware = new HardwareManager(hardwareMap);

        leftFrontDrive = hardware.leftFrontDrive;
        leftRearDrive = hardware.leftRearDrive;
        rightFrontDrive = hardware.rightFrontDrive;
        rightRearDrive = hardware.rightRearDrive;

        leftActuator = hardware.leftActuator;
        rightActuator = hardware.rightActuator;

        latch = hardware.latch;

        commands = new AutoCommands(hardware, telemetry);
        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod();
        } else {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }
        CameraDevice.getInstance().setFlashTorchMode(true);

        while (!opModeIsActive() && !isStopRequested()) {
            telemetry.addData("status", "waiting for start command...");
            telemetry.update();
        }
        waitForStart();
        if (opModeIsActive()) {
            /** Activate Tensor Flow Object Detection. */
            if (tfod != null) {
                tfod.activate();
            }
        }
        // extend elevator to full. Assumes positive voltage extends the elevator
        leftActuator.setVolt(1);
        rightActuator.setVolt(1);
        sleep(AutoConstants.MILLISECONDS_TILL_FULL_ELEVATOR_EXTENSION);

        latch.setPower(-1);
        sleep(AutoConstants.MILLISECONDS_TO_DETACH_LATCH);
        latch.setPower(0);
        sleep(AutoConstants.MILLISECONDS_TO_WAIT);
        // drive forwards for predefined time in milliseconds
        alignAndHitMineral();
    }

    /**
     * Initialize the Vuforia localization engine.
     */
    private void initVuforia() {
        /*
         * Configure Vuforia by creating a Parameter object, and passing it to the
         * Vuforia engine.
         */
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = MineralConstants.VUFORIA_KEY;
        parameters.cameraDirection = CameraDirection.BACK;

        // Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the Tensor Flow Object Detection
        // engine.
    }

    private void alignAndHitMineral() {
        while (opModeIsActive() && !isDone) {
            if (tfod != null) {
                // getUpdatedRecognitions() will return null if no new information is available
                // since
                // the last time that call was made.
                List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                if (updatedRecognitions != null) {
                    telemetry.addData("# Object Detected", updatedRecognitions.size());
                    if (updatedRecognitions.size() != 0) {
                        int goldMineralX = TARGET_NOT_DETECTED;
                        int silverMineral1X = TARGET_NOT_DETECTED;
                        int silverMineral2X = TARGET_NOT_DETECTED;
                        Recognition imageCenterCalc = updatedRecognitions.get(0);
                        int centerX = imageCenterCalc.getImageWidth() / 2;
                        int goldMineralCenterX = TARGET_NOT_DETECTED;
                        for (Recognition recognition : updatedRecognitions) {
                            if (recognition.getLabel().equals(MineralConstants.LABEL_GOLD_MINERAL)) {
                                goldMineralCenterX = (int) (recognition.getLeft() + recognition.getRight()) / 2;

                            }
                        }
                        if (goldMineralX != TARGET_NOT_DETECTED && silverMineral1X != TARGET_NOT_DETECTED
                                && silverMineral2X != TARGET_NOT_DETECTED) {
                            if (goldMineralX < silverMineral1X && goldMineralX < silverMineral2X) {
                                telemetry.addData("Gold Mineral Position", "Left");
                            } else if (goldMineralX > silverMineral1X && goldMineralX > silverMineral2X) {
                                telemetry.addData("Gold Mineral Position", "Right");
                            } else {
                                telemetry.addData("Gold Mineral Position", "Center");
                            }
                        }
                        int error = centerX - goldMineralCenterX;
                        // if gold isn't detected, stop moving
                        if (goldMineralCenterX == TARGET_NOT_DETECTED) {
                            pidLoop(0);
                            Log.i(loggingName, "Gold Mineral X not detected");
                            telemetry.addData("Gold Mineral X", "not detected");
                        }

                        else {
                            telemetry.addData("Center", centerX);
                            Log.i(loggingName, "CenterX is " + centerX);
                            telemetry.addData("Error ", error);
                            telemetry.addData("Gold Mineral X", goldMineralCenterX);
                            Log.i(loggingName, "Error " + error);
                            Log.i(loggingName, "Gold Mineral X " + goldMineralCenterX);
                            if (pidLoop(error)) {
                                // move forward for 100 milliseconds
                                commands.driveForward(.5);
                                sleep(TIME_TO_MOVE_FORWARD);
                                isDone = true;
                            }

                        }

                        telemetry.update();

                    }
                }
            }
        }
        if (tfod != null) {
            tfod.shutdown();
        }
    }

    /**
     * s Initialize the Tensor Flow Object Detection engine.
     */
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("tfodMonitorViewId", "id",
                hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(MineralConstants.TFOD_MODEL_ASSET, MineralConstants.LABEL_GOLD_MINERAL,
                MineralConstants.LABEL_SILVER_MINERAL);
    }

    // may need to scale this down so it stops losing track
    // returns true when done
    private boolean pidLoop(int error) {
        // kp .00035 no moving
        double kp = 0.0035;
        double sideShiftPower = -(error * kp);
        if (sideShiftPower > 0) {
            // puts max power at .5
            sideShiftPower = Math.min(sideShiftPower, .5);
        } else if (sideShiftPower < 0) {
            // puts max power (abs) at -.5
            sideShiftPower = Math.max(sideShiftPower, -.5);
        }
        if (Math.abs(sideShiftPower) < .3) {
            return true;

        }
        telemetry.addData("PID Loop error", error);
        telemetry.addData("PID Loop applied power", sideShiftPower);
        commands.HorizontalMove(sideShiftPower);
        Log.i(loggingName, "Power for pid is " + sideShiftPower);
        Log.i(loggingName, "Error for pid is " + error);
        telemetry.update();
        return false;
    }
}
