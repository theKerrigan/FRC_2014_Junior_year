package com.fpsrobotics;

import com.fpsrobotics.preset.*;
import edu.wpi.first.wpilibj.AnalogChannel;
import java.util.Enumeration;

/**
 *
 * @author Hackbots
 */
public class Catapult
{

    private final AnalogChannel shooterPot;
    private final Motor shooterMotor;
    private static Catapult singleton = null;
    private boolean isFiring;

    private Catapult(AnalogChannel pot, Motor shooterMotor)
    {
        this.shooterPot = pot;
        this.shooterMotor = shooterMotor;
    }

    public static Catapult createInstance(AnalogChannel pot, Motor shooterMotor)
    {
        if (singleton == null)
        {
            singleton = new Catapult(pot, shooterMotor);
        }

        return singleton;
    }

    public static Catapult getInstance()
    {
        if (singleton == null)
        {
            throw new NullPointerException("Catapult Instance isn't Defined and is null");
        }
        
        return singleton;
    }

    public void shoot(Preset preset)
    {
        isFiring = true;

        if (!SpinnySticks.getInstance().areSpinnySticksUp())
        {
            Enumeration presetValues = preset.getElements();
            while (presetValues.hasMoreElements())
            {
                PresetValue nextElement = (PresetValue) presetValues.nextElement();

                if (nextElement.getSpeed() == Preset.STOP_SHOOTER)
                {
                    shooterMotor.stop();
                } else if (nextElement.getAngle() > shooterPot.getValue())
                {
                    moveCatapultForward(nextElement);
                } else if (nextElement.getAngle() < shooterPot.getValue())
                {
                    moveCatapultBackward(nextElement);
                } else
                {
                    // The value is equal move to next element
                }

            }
        }

        isFiring = false;
    }

    public void moveCatapultForward(PresetValue nextElement)
    {
        System.out.println(Math.abs(nextElement.getSpeed()));

        this.shooterMotor.forward(Math.abs(nextElement.getSpeed()));

        while (nextElement.getAngle() > shooterPot.getValue())
        {

        }
    }

    public void moveCatapultBackward(PresetValue nextElement)
    {
        System.out.println(Math.abs(nextElement.getSpeed()));

        this.shooterMotor.backward(Math.abs(nextElement.getSpeed()));

        while (nextElement.getAngle() < shooterPot.getValue())
        {

        }
    }

    public boolean isFiring()
    {
        return isFiring;
    }
}
