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
 * constants are needed, to reduce verbosity.+
 */
public final class Constants {

    private Constants() {
        /* disallow construction of this class */
        throw new UnsupportedOperationException("don't try to construct an instance of Constants");
    }


    public static class Motor {
        public static final int kLeft1Id = 2;
        public static final int kLeft2Id = 22;
        public static final int kRight1Id = 1;
        public static final int kRight2Id = 21;
        public static final int sensitivity = 5;
        public static final int pcmID = 5; 

    }


    public static class Arm {

        public static final int kLeftId = 9;
        public static final int kRightId = 10;
        public static final int kCANCoderId = 0;

        public static final int MOVE_ARM_UP_BUTTON = 3;
        public static final int MOVE_ARM_DOWN_BUTTON = 2;
       
        public static final double ArmMoveSpeed = 0.2;
        


    }

    public static class Music {

        public static final String fileName = "MegalovaniaForChomp.chrp";
        //5 is the loose one
        public static final int kMusic1Id = 5;
        public static final int kMusic2Id = 4;
        
        public static final int kMusic3Id = 4;//change in future
        public static final int kMusic4Id = 7;
        public static final int kMusic5Id = 10;
    }

    public static class Climb{

        public static final int kClimbLeft = 11;
        public static final int kClimbRight = 12;
    
    }

    

    public static class RobotContainer {

        public static final int Ajoystick = 0;
        public static final int MOTOR_BUTTON = 3;
        public static final int BRAKE_BUTTON = 1;
        public static final int PLAY_MUSIC_BUTTON = 6;
        
    }

}
