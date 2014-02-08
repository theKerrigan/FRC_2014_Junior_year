package com.fpsrobotics.interfaces;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * Where DIOs are created, so they can be easily changed
 *
 * @author ray
 */
public interface DIOs extends DeviceMap
{

    // DIOs here
    Encoder shooterEncoder = new Encoder(SHOOTER_ENCODER_MAP_ONE, SHOOTER_ENCODER_MAP_TWO);
    Encoder leftDriveEncoder = new Encoder(LEFT_DRIVE_ENCODER_MAP_ONE, LEFT_DRIVE_ENCODER_MAP_TWO);
    Encoder rightDriveEncoder = new Encoder(RIGHT_DRIVE_ENCODER_MAP_ONE, RIGHT_DRIVE_ENCODER_MAP_TWO);
    Compressor compressor = new Compressor(COMPRESSOR_DIO_MAP, COMPRESSOR_RELAY_SPIKE_MAP);
    DigitalOutput distanceOutput = new DigitalOutput(DISTANCE_OUTPUT_MAP);
    DigitalInput distanceInput = new DigitalInput(DISTANCE_INPUT_MAP);
    Ultrasonic distanceSensor = new Ultrasonic(distanceOutput, distanceInput);

}
