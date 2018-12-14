
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angga
 */
public class crud {
    public void crudOperator(char operation,String id_operator, String nama_operator, String email_operator,
            String alamat_operator, String divisi_operator, String pass_operator, String ImgPath)
    {
        Connection con = koneksiDB.getConnection();
        PreparedStatement ps;
        
        if(operation == 'i')
        {
            try {
                InputStream img = null;
                try {
                    img = new FileInputStream(new File(ImgPath));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
                }
                ps = con.prepareStatement("insert into operator (nama_operator, email_operator, alamat_operator,devisi_operator,password_operator, foto_operator) values (?,?,?,?,?,?)");
                //ps.setString(1, id_operator);
                ps.setString(1, nama_operator);
                ps.setString(2, email_operator);
                ps.setString(3, alamat_operator);
                ps.setString(4, divisi_operator);
                ps.setString(5, pass_operator);
                ps.setBlob(6, img);
                
                
                
                if(ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, "Operator ditambah");
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(operation == 'u')
        {
            if(ImgPath == null)
            {
                try {
                    ps = con.prepareStatement("update operator set nama_operator=?,alamat_operator=?,email_operator=?,divisi_operator=? where id_operator=?");
                    ps.setString(1, nama_operator);
                    ps.setString(2, email_operator);
                    ps.setString(3, alamat_operator);
                    ps.setString(4, divisi_operator);
                

                    if(ps.executeUpdate() > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Data Operator telah di update");
                    }
                } 
                catch (SQLException ex) {
                    Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                try {
                    InputStream img = null;
                    try {
                        img = new FileInputStream(new File(ImgPath));
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ps = con.prepareStatement("update operator set nama_operator=?,email_operator=?,alamat_operator=?,divisi_operator=?, foto_operator=? where id_operator=?");
                    ps.setString(1, nama_operator);
                    ps.setString(2, email_operator);
                    ps.setString(3, alamat_operator);
                    ps.setString(4, divisi_operator);
                    ps.setBlob(5, img);
                    if(ps.executeUpdate() > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Data Operator telah di update");
                    }
                } 
                catch (SQLException ex) {
                    Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if(operation == 'd')
        {
            try {
                    ps = con.prepareStatement("delete from operator where id_operator=?");
                    ps.setString(1, nama_operator);

                    if(ps.executeUpdate() > 0)
                        JOptionPane.showMessageDialog(null, "Data Operator dihapus");
                } 
                catch (SQLException ex) {
                    Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    public void crudOperator(char operation, String email_operator, String password_operator)
    {
        Connection con = koneksiDB.getConnection();
        PreparedStatement ps;
        
        if(operation == 'p')
        {
            try {
                ps = con.prepareStatement("update operator set password_operator=? where email_operator.email_operator=?");
                ps.setString(1, password_operator);
                ps.setString(2, email_operator);
                
                if(ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, "Password berhasil diganti");
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public ArrayList<String> getData(int id_operator)
    {
        ArrayList<String> data = new ArrayList<String>();
        Connection con = koneksiDB.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from operator where id_operator= ?");
            ps.setInt(1, id_operator);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                //System.out.println(rs.getString(1));
                data.add(rs.getString(1));
                data.add(rs.getString(2));
                data.add(rs.getString(3));
                data.add(rs.getString(4));
                data.add(rs.getString(5));
            }
        } catch (SQLException e) {
        }
        return data;
    }
    public void fillOperatorTabel(JTable table, String valueToSearch)
    {
        Connection con = koneksiDB.getConnection();
        PreparedStatement ps;
        //System.out.println("%"+valueToSearch+"%");
        try {
            ps = con.prepareStatement("select * from operator where concat(id_operator,nama_operator,email_operator,alamat_operator,password_operator,devisi_operator) like ?");
            ps.setString(1, "%"+valueToSearch+"%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[6];
                row[0] = rs.getString(1);                
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(5);
                row[4] = rs.getString(6);
                row[5] = rs.getString(4);
                model.addRow(row);                
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public byte[] getimg(String id_operator)
    {
        Connection con = koneksiDB.getConnection();
        PreparedStatement ps;
        byte[] pic = null;
        try {
            ps = con.prepareStatement("select foto_operator from operator where id_operator=?");
            ps.setString(1, id_operator);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                pic = rs.getBytes("foto_operator");
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pic;
    }

   
}
