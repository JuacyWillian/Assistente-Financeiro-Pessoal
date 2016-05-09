package afp.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaDeEntidades {

    private static EntityManagerFactory emf;

    private FabricaDeEntidades() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("AssistentePessoalPU");
        }
        return emf;
    }
}
