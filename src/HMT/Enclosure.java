package HMT;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 * Created by mohsin on 1/3/2015.
 */
public class Enclosure {
    Server server;

    public Enclosure() {
        server = new Server();
    }

    public double roofOptimumL(double T1, double T2) {
        if (T2 >= T1) return -1;
        double g, B, Pr, v, L;
        g = 9.81;
        B = 1 / (((T1 + T2) / 2) + 273);
        Pr = server.getPr((T1 + T2) / 2);
        v = server.getV((T1 + T2) / 2);
        L = pow(((1708 * pow(v, 2)) / (g * B * (T1 - T2) * Pr)), 1.0 / 3.0);
        return L;
    }

    public double windowOptimumL(double T1, double T2, double H) {
        if (T2 == T1) return -1;
        double g, B, Pr, v, L;
        g = 9.81;
        B = 1 / (((T1 + T2) / 2) + 273);
        Pr = server.getPr((T1 + T2) / 2);
        v = server.getV((T1 + T2) / 2);
        L = pow((pow(H, 0.3) * pow(v, 0.5)) /
                (0.42 * pow(g, 0.25) * pow(B, 0.25) * pow(abs(T1 - T2), 0.25) * pow(Pr, 0.262)), 1 / 1.05);
        return L;
    }
}
