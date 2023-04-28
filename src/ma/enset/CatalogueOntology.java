package ma.enset;

import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.schema.*;

public class CatalogueOntology extends Ontology implements CatalogueVocabolary {
    //le nom de l'ontologie
    public static final String ONTOLOGY_NAME ="Catalogue-Ontology";
    private  static  final Ontology CATALOG_ONTOLOGY= new CatalogueOntology();

    public static Ontology getCatalogOntology() {
        return CATALOG_ONTOLOGY;
    }

    private CatalogueOntology(){
        super(ONTOLOGY_NAME , BasicOntology.getInstance());
        try {
            add(new ConceptSchema(PRODUCT) , Product.class);
            add(new ConceptSchema(COMPUTER) , Computer.class);
            add(new ConceptSchema(USB) , Usb.class);
            add(new AgentActionSchema(SELL) , Sell.class);
            add(new PredicateSchema(DISPONIBLE) , Disponible.class);

            ConceptSchema ps = (ConceptSchema) getSchema(PRODUCT);
            ps.add(PRODUCT_NAME , (PrimitiveSchema)getSchema(BasicOntology.STRING) , ObjectSchema.OPTIONAL);
            ps.add(PRODUCT_PRICE ,(PrimitiveSchema) getSchema(BasicOntology.FLOAT) , ObjectSchema.OPTIONAL);

            ConceptSchema cs = (ConceptSchema) getSchema(COMPUTER);
            cs.addSuperSchema(ps);
            cs.add(COMPUTER_RAM , (PrimitiveSchema) getSchema(BasicOntology.FLOAT) ,ObjectSchema.OPTIONAL);
            cs.add(COMPUTER_DISK , (PrimitiveSchema) getSchema(BasicOntology.FLOAT) ,ObjectSchema.OPTIONAL );
            cs.add(COMPUTER_PROCESSORS, (PrimitiveSchema) getSchema(BasicOntology.INTEGER) ,ObjectSchema.OPTIONAL);

            ConceptSchema u = (ConceptSchema) getSchema(USB);
            u.addSuperSchema(ps);
            u.add(USB_CAPACITY , (PrimitiveSchema) getSchema(BasicOntology.FLOAT) , ObjectSchema.OPTIONAL);

            PredicateSchema ds = (PredicateSchema) getSchema(DISPONIBLE);
            ds.add(DISPONIBLE_PRODUCT , ps);
            ds.add(DISPONIBLE_SELLER , getSchema(BasicOntology.AID) , ObjectSchema.OPTIONAL);

            AgentActionSchema ss = (AgentActionSchema)getSchema(SELL);
            ss.add(SELL_PRODUCT , ps);
            ss.add(SELL_BUYER , (ConceptSchema) getSchema(BasicOntology.AID) , ObjectSchema.OPTIONAL);





        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public CatalogueOntology(String name, Ontology base) {
        super(name, base);
    }
}
