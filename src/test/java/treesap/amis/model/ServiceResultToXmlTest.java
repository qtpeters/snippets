package treesap.amis.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceResultToXmlTest {
    private LocalDateTimeAdapter dateFormat = new LocalDateTimeAdapter();

    private ServiceResult serviceResult;

    @Before
    public void setUp() throws Exception {
        Item item1 = new Item();
        item1.setRegistered(false);
        item1.setRegisteredForSecurityQuestions(false);
        item1.setFirstName("amis");
        item1.setLastName("bind");
        item1.setEnabled(true);
        item1.setLocked(false);
        item1.setPid("dn.CN%3Damisbind%2COU%3DRSAUsers%2COU%3DAccounts%2CDC%3DTheForest%2CDC%3DSAP");
        item1.setUserId("amisbind");
        item1.setCustomAttributes(new CustomAttributes());
        item1.setSecurityDomain("SystemDomain");
        item1.setIdentitySource("theforest.sap");
        item1.setInternal(false);
        item1.setFixedPasscodeSet(false);
        Item item2 = new Item();
        item2.setRegistered(true);
        item2.setRegisteredForSecurityQuestions(false);
        item2.setAccountStartDate(dateFormat.unmarshal("2019-04-24T21:13:44.106Z"));
        item2.setFirstName("A");
        item2.setEnabled(true);
        item2.setLocked(false);
        item2.setLastModifiedBy("sapAdmin");
        item2.setLastModifiedOn(dateFormat.unmarshal("2020-02-07T14:15:50.850Z"));
        item2.setLastName("A");
        item2.setPid("ims.1a289ddd2001a8c07d6bf09e03546b96");
        item2.setUserId("aaa");
        AttributeValues attributeValues = new AttributeValues();
        attributeValues.setValues(Arrays.asList("+12065557981"));
        List<AttributeValues> attributeValueList = Arrays.asList(attributeValues);
        Attribute attribute = new Attribute();
        attribute.setName("mobile");
        attribute.setValues(attributeValueList);
        List<Attribute> attributes = Arrays.asList(attribute);
        CustomAttributes customAttributes = new CustomAttributes();
        customAttributes.setAttribute(attributes);
        item2.setCustomAttributes(customAttributes);
        item2.setSecurityDomain("jade");
        item2.setIdentitySource("Internal Database");
        item2.setInternal(true);
        item2.setBadPasscodeCount(0);
        item2.setPasswordModifiedDate(dateFormat.unmarshal("2020-01-09T18:34:51.419Z"));
        item2.setFixedPasscodeSet(false);
        List<Item> items = Arrays.asList(item1, item2);
        UserSearchResults userSearchResults = new UserSearchResults();
        userSearchResults.setCount(items.size());
        userSearchResults.setItems(items);
        serviceResult = new ServiceResult();
        serviceResult.setUserSearchResults(userSearchResults);
    }

    @After
    public void tearDown() {
        serviceResult = null;
    }

    @Test
    public void testSearchResultsToXml() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(ServiceResult.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(serviceResult, System.out);
    }
}
