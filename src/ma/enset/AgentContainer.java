package ma.enset;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;

public class AgentContainer {
    public static void main(String[] args)  throws Exception {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter(ProfileImpl.MAIN_HOST , "localhost");
        jade.wrapper.AgentContainer clientContainer = runtime.createAgentContainer(profile);
        AgentController sellerController = clientContainer.createNewAgent("seller","ma.enset.SellerAgent",new Object[]{});
        AgentController buyerController = clientContainer.createNewAgent("buyer","ma.enset.BuyerAgent",new Object[]{});
        buyerController.start();
        sellerController.start();

    }
}
