package com.solproe.shared;

import java.nio.file.Path;

public class PathGlobal {
    public static Path path = null;

    private PathGlobal () {

    }

    public static void generatePath (Path newPath) {
        if (path == null) {
            path = newPath;
        }
    }

    public static Path getPath() {
        return path;
    }
}
