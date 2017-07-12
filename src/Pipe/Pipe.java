package Pipe;


import java.io.*;

public class Pipe {
private DataOutputStream out;
private DataInputStream in;

public Pipe() throws IOException {
    PipedOutputStream pOut = new PipedOutputStream();
    PipedInputStream pIn = new PipedInputStream();
    pOut.connect(pIn);
    out = new DataOutputStream(pOut);
    in = new DataInputStream(pIn);
}

    public void put (int value) throws IOException {
    out.writeInt(value);
    }

    public int get () throws IOException {
       return  in.readInt();
    }

    public void close () throws IOException {
        out.close();
    }
}
