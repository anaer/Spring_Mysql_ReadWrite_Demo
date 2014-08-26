package blog.datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

@SuppressWarnings("deprecation")
public class Catalog extends SimpleJdbcDaoSupport {

    public List<Item> getItems() {
	String query = "select name, price from item";
	return getSimpleJdbcTemplate().query(query, new ParameterizedRowMapper<Item>() {
	    @Override
	    public Item mapRow(ResultSet rs, int row) throws SQLException {
		String name = rs.getString(1);
		double price = rs.getDouble(2);
		return new Item(name, price);
	    }
	});
    }
}