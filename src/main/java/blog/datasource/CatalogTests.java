package blog.datasource;

import java.util.List;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class CatalogTests extends AbstractDependencyInjectionSpringContextTests {

    private Catalog catalog;

    public void setCatalog(Catalog catalog) {
	this.catalog = catalog;
    }

    public void testDataSourceRouting() {
	CustomerContextHolder.setCustomerType(CustomerType.GOLD);
	List<Item> goldItems = catalog.getItems();
	assertEquals(3, goldItems.size());
	System.out.println("gold items: " + goldItems);

	CustomerContextHolder.setCustomerType(CustomerType.SILVER);
	List<Item> silverItems = catalog.getItems();
	assertEquals(2, silverItems.size());
	System.out.println("silver items: " + silverItems);

	CustomerContextHolder.clearCustomerType();
	List<Item> bronzeItems = catalog.getItems();
	assertEquals(1, bronzeItems.size());
	System.out.println("bronze items: " + bronzeItems);
    }

    @Override
    protected String[] getConfigLocations() {
	return new String[] { "/blog/datasource/beans.xml" };
    }
}