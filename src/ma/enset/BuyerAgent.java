package ma.enset;

import jade.content.ContentElement;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class BuyerAgent extends Agent {
    private Ontology catalogOntology = CatalogueOntology.getCatalogOntology();
    private Codec codec= new SLCodec();

    @Override
    protected void setup() {
        getContentManager().registerOntology(catalogOntology);
        getContentManager().registerLanguage(codec);

        MessageTemplate template = MessageTemplate.and( MessageTemplate.MatchOntology(CatalogueOntology.ONTOLOGY_NAME) , MessageTemplate.MatchLanguage(codec.getName()));
        ACLMessage receivedMsg = blockingReceive(template);
        try {
            Disponible disponible = (Disponible)getContentManager().extractContent(receivedMsg);
            System.out.println(disponible.getProduct().getName()+disponible.getProduct().getPrice());

        } catch (Codec.CodecException e) {
            throw new RuntimeException(e);
        } catch (OntologyException e) {
            throw new RuntimeException(e);
        }
    }
}
