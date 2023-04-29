package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.TaiKhoan;

public class SignUpDao extends DBconnect {
	public TaiKhoan checkAccount(String user) {
		String query = "select * from taikhoan where [taikhoan]=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TaiKhoan a = new TaiKhoan(rs.getInt(1), rs.getString(2), rs.getString(3));
				System.out.println(a);
				return a;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return null;
	}

	public void NewAccount(String name, String pass) {
		String query = "insert into taikhoan value (2,?,?);";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, pass);
			ps.executeUpdate();
			// k can dung result vi khi usertao tai khoan se k co du lieu tra ve
			// can dung [executeUpdate()] de update lai du lieu
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}