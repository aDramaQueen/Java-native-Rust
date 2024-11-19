package org.example;

import java.util.Set;

/**
 * This class detects the currently used operating system architecture at runtime.
 */
public enum OperatingSystemArchitecture {

    x86(Set.of("x86", "i386", "i486", "i586", "i686")),
    x86_64(Set.of("x86_64", "amd64", "k8")),
    arm(Set.of("arm", "arm64"));

    public final Set<String> identifiers;

    OperatingSystemArchitecture(Set<String> name) {
        this.identifiers = name;
    }

    /**
     * System property for currently running operating system
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/System.html#getProperties()">System properties</a>
     * @see <a href="https://github.com/apache/commons-lang/blob/master/src/main/java/org/apache/commons/lang3/SystemUtils.java">Apache Commons Implementation</a>
     */
    public static OperatingSystemArchitecture getCurrentArchitecture() {

        String architectureIdentifier = System.getProperty("os.arch").toLowerCase();
        for (OperatingSystemArchitecture arch : OperatingSystemArchitecture.values()) {
            if (arch.identifiers.contains(architectureIdentifier)) {
                return arch;
            }
        }
        throw new IllegalStateException("Unknown operating system architecture");
    }
}
