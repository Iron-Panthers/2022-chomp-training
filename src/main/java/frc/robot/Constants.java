// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    private Constants() {
        /* disallow construction of this class */
        throw new UnsupportedOperationException("don't try to construct an instance of Constants");
    }


    public static class Motor {
        public static final int kLeft1Id = 1;
        public static final int kLeft2Id = 2;
        public static final int kRight1Id = 3;
        public static final int kRight2Id = 4;

    }

    public static class RobotContainer {

        public static final int Ajoystick = 1;
        public static final int MOTOR_BUTTON = 3;
        public static final int BRAKE_BUTTON = 1;
        
    }

    
      
    



}
