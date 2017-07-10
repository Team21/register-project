package utils;

import java.lang.reflect.Field;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;



import entity.Admin;

public class BaseDao {
	
	
	private  Connection con;
	private   PreparedStatement pstmt;
	private  ResultSet rs;

	
	public  void update(String sql,Object[] paramsValue)
	{
		

		try {
			con = JdbcUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			ParameterMetaData parameterMetaData = pstmt.getParameterMetaData();
			int parameterCount = parameterMetaData.getParameterCount();
			
			for(int i=1;i<=parameterCount;i++)
			{
				pstmt.setObject(i, paramsValue[i-1]);
			}
			pstmt.executeUpdate();	
				
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeAll(con, pstmt, null);
		}
		
		
	}
	
	public <T> List<T> query(String sql, Object[] paramsValue,Class<T> clazz)
	{
		try {
			
			
			 con=JdbcUtil.getConnection();
			 pstmt = con.prepareStatement(sql);
			ParameterMetaData parameterMetaData = pstmt.getParameterMetaData();
			int parameterCount = parameterMetaData.getParameterCount();
			
			for(int i=1;i<=parameterCount;i++)
			{
				pstmt.setObject(i, paramsValue[i-1]);
			}
			 rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			List<T> list=new ArrayList<>();
			
			while (rs.next()) {
				T t=(T)clazz.newInstance();
				int columnCount = metaData.getColumnCount();
				for(int i=0;i<=columnCount-1;i++){
					String name=metaData.getColumnName(i+1);
					Object object =rs.getObject(name);
					
					Field ified=clazz.getDeclaredField(name);
					ified.setAccessible(true);
					ified.set(t, object);
				}
				list.add(t);
			}
		
			return list;
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeAll(con, pstmt, null);
		
		}
		
		
		
		
		
		
	}

	public BaseDao() {
		// TODO Auto-generated constructor stub
	}



}
