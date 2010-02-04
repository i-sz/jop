package scd_micro;


/**
 * All of our globally relevant constants.
 * @author Filip Pizlo
 */
public final class Constants {
	public static int NOISE_RATE = 0;
	public static final float MIN_X = 0.0f;
	public static final float MIN_Y = 0.0f;
	public static final float MAX_X = 1000.0f;
	public static final float MAX_Y = 1000.0f;
	public static final float MIN_Z = 0.0f;
	public static final float MAX_Z = 10.0f;
	public static final float PROXIMITY_RADIUS = 1.0f;
	public static final float GOOD_VOXEL_SIZE = PROXIMITY_RADIUS * 2.0f;

	public static int SIMULATOR_PRIORITY = 5;
	public static int DETECTOR_STARTUP_PRIORITY = 20;
	public static int DETECTOR_PRIORITY = DETECTOR_STARTUP_PRIORITY + 1;    
	public static long PERSISTENT_DETECTOR_SCOPE_SIZE = 10* 10 * 1000 * 1024;
	public static long DETECTOR_PERIOD = 500;
	public static long TRANSIENT_DETECTOR_SCOPE_SIZE = 10 * 10 * 1048576;

	public static int MAX_FRAMES = 100;

	public static int TIME_SCALE = 1;
	public static int FPS = 50;
	public static int BUFFER_FRAMES = 1000;
	public static boolean PRESIMULATE = false;
	public static boolean SIMULATE_ONLY = false;

	public static final String DETECTOR_STATS = "detector.rin";
	public static final String SIMULATOR_STATS = "simulator.rin";    
	public static final String DETECTOR_RELEASE_STATS = "release.rin";

  //run a SPEC jvm98 benchmark to generate some noise
	public static String SPEC_NOISE_ARGS = "-a -b -g -s100 -m10 -M10 -t _213_javac";
	public static boolean USE_SPEC_NOISE = false;

	public static int DETECTOR_NOISE_REACHABLE_POINTERS = 1000000;
	public static int DETECTOR_NOISE_ALLOCATE_POINTERS = 10000;
	public static int DETECTOR_NOISE_ALLOCATION_SIZE = 64;
	public static boolean DETECTOR_NOISE_VARIABLE_ALLOCATION_SIZE = false;
	public static int DETECTOR_NOISE_ALLOCATION_SIZE_INCREMENT = 13;
	public static int DETECTOR_NOISE_MIN_ALLOCATION_SIZE = 128;
	public static int DETECTOR_NOISE_MAX_ALLOCATION_SIZE = 16384;
	public static int DETECTOR_STARTUP_OFFSET_MILLIS = 3000;
	public static boolean DETECTOR_NOISE = false;

	// write down the FRAMES into the frame.bin file
	public static boolean FRAMES_BINARY_DUMP = false; 

	
	
	// this is only for debugging of the detector code
	//
	// each frame generated by the simulator is processed exactly once by
	// the detector ; this also turns on some debugging features
	//
	// the results thus should be deterministic
	public static boolean SYNCHRONOUS_DETECTOR = false;    

	public static boolean DUMP_RECEIVED_FRAMES = false;
	public static boolean DUMP_SENT_FRAMES = false;
	public static boolean DEBUG_DETECTOR = false;

}