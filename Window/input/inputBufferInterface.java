package Window.input;

import java.util.HashSet;
import java.util.Set;

public interface inputBufferInterface {
    public Set<Integer> inputBuffer = new HashSet<>();
    public int speedFactor = 4;

    public int GenericNPCspeedFactor = 2;
}
