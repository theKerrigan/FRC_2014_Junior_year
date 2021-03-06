package com.fpsrobotics.hardware;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * @author Josh
 */
public class DigitalIOs
{

    public final static Encoder LEFT_DRIVE_ENCODER = new Encoder(HardwarePorts.LEFT_DRIVE_ENCODER_ONE, HardwarePorts.LEFT_DRIVE_ENCODER_TWO);
    public final static Encoder RIGHT_DRIVE_ENCODER = new Encoder(HardwarePorts.RIGHT_DRIVE_ENCODER_ONE, HardwarePorts.RIGHT_DRIVE_ENCODER_TWO);
    public final static Compressor COMPRESSOR = new Compressor(HardwarePorts.COMPRESSOR, HardwarePorts.COMPRESSOR_SPIKE_RELAY);
}
