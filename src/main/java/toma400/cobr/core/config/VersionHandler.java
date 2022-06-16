package toma400.cobr.core.config;

public class VersionHandler {

    /** <b>SMOOTH CONFIG VERSION HANDLING (SCVH)</b>
     *
     *  <p>SCVH server purpose of handling configs being changed with time, to ensure user don't
     *  need to update them manually by removing the file. Purpose of this system is to overwrite
     *  the config if there's newer version available, but to keep old values if they are altered
     *  already.
     */

    public static final Double CURRENT_CONFIG_VERSION = 0.1;

    public static void mainHandler(Double fileVersion) {
        while (!(versionChecker(fileVersion))) {
            // --------------------------------------------------------------------------------
            // Once there are differences in config, put here actions which would save previous
            // settings, reload the config, updating its contents, and then overwrite values
            // where there was values earlier
            // -------------------------------
            // It is made as a loop since the easiest way to handle the thing will be to make
            // function for each config difference (0.1 -> 0.2, 0.2 -> 0.3) and just run this
            // through all versions, because making dedicated methods for, for example,
            // 0.1 -> 0.4 conversion would make so much more unnecessary shit to code.
            // --------------------------------------------------------------------------------
            if (fileVersion == 0.1) {
                v01to02();
            }
            break;
        }
    }

    public static Boolean versionChecker (Double fileVersion) {
        return fileVersion.equals(CURRENT_CONFIG_VERSION);
    }

    public static void v01to02() {
        // version 0.1 -> 0.2, to do once 0.2 is made
    }
}
