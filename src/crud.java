
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
import java.sql.Statement;

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
    public void crudOperatorall(char operation, String id_operator,String nama_operator, String email_operator,String alamat_operator, String devisi_operator, String ImgPath)
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
                ps = con.prepareStatement("insert into operator (id_operator,nama_operator, alamat_operator, password_operator,devisi_operator, foto_operator) values (?,?,?,?,?,?)");
                ps.setString(1, id_operator);
                ps.setString(2, nama_operator);
                ps.setString(3, email_operator);
                ps.setString(4, alamat_operator);
                ps.setString(5, devisi_operator);
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
                    ps = con.prepareStatement("update operator set nama_operator=?,alamat_operator=?,email_operator=?,devisi_operator=? where id_operator=?");
                    ps.setString(1, nama_operator);
                    ps.setString(2, email_operator);
                    ps.setString(3, alamat_operator);
                    ps.setString(4, devisi_operator);
                

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
                    ps = con.prepareStatement("update operator set nama_operator=?,email_operator=?,alamat_operator=?,devisi_operator=?, foto_operator=? where id_operator=?");
                    ps.setString(1, nama_operator);
                    ps.setString(2, email_operator);
                    ps.setString(3, alamat_operator);
                    ps.setString(4, devisi_operator);
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
                    ps.setString(1, id_operator);

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
                ps = con.prepareStatement("update operator set password_operator=? where operator.email_operator=?");
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
    
    public void crudVolunteer(char operation, String id_volunteer,String nama_volunteer, String email_volunteer, String pass_volunteer,
            String alamat_volunteer, String devisi_volunteer, String ImgPath)
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
                ps = con.prepareStatement("insert into volunteer (id_volunteer,nama_volunteer, alamat_volunteer, password_volunteer, foto_volunteer) values (?,?,?,?,?)");
                ps.setString(1, id_volunteer);
                ps.setString(2, nama_volunteer);
                ps.setString(3, email_volunteer);
                ps.setString(4, pass_volunteer);
                ps.setString(5, alamat_volunteer);
                ps.setString(6, devisi_volunteer);
                ps.setBlob(7, img);
                
                
                
                if(ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null, "Volunteer ditambah");
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
                    ps = con.prepareStatement("update volunteer set nama_volunteer=?,alamat_volunteer=?,email_volunteer=?,divisi_volunteer=? where id_volunteer=?");
                    ps.setString(1, nama_volunteer);
                    ps.setString(2, email_volunteer);
                    ps.setString(3, alamat_volunteer);
                    ps.setString(4, devisi_volunteer);
                

                    if(ps.executeUpdate() > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Data Volunteer telah di update");
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
                    ps = con.prepareStatement("update volunteer set nama_volunteer=?,email_volunteer=?,alamat_volunteer=?,divisi_volunteer=?, foto_volunteer=? where id_volunteer=?");
                    ps.setString(1, nama_volunteer);
                    ps.setString(2, email_volunteer);
                    ps.setString(3, alamat_volunteer);
                    ps.setString(4, devisi_volunteer);
                    ps.setBlob(5, img);
                    if(ps.executeUpdate() > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Data volunteer telah di update");
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
                    ps = con.prepareStatement("delete from volunteer where id_volunteer=?");
                    ps.setString(1, id_volunteer);

                    if(ps.executeUpdate() > 0)
                        JOptionPane.showMessageDialog(null, "Data volunteer dihapus");
                } 
                catch (SQLException ex) {
                    Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    public void crudVolunteer(char operation, String email_volunteer, String password_volunteer)
    {
        Connection con = koneksiDB.getConnection();
        PreparedStatement ps;
        
        if(operation == 'p')
        {
            try {
                ps = con.prepareStatement("update volunteer set password_volunteer=? where email_volunteer.email_volunteer=?");
                ps.setString(1, password_volunteer);
                ps.setString(2, email_volunteer);
                
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
    
    public ArrayList<String> getDataVolunteer(int id_volunteer)
    {
        ArrayList<String> data = new ArrayList<String>();
        Connection con = koneksiDB.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("select * from volunteer where id_volunteer= ?");
            ps.setInt(1, id_volunteer);
            
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
        
        try {
            ps = con.prepareStatement("select * from operator where concat(id_operator,nama_operator,email_operator,password_operator,alamat_operator,devisi_operator,foto_operator) like ?");
            ps.setString(1, "%"+valueToSearch+"%");
            
            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[7];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                model.addRow(row);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getVolunteerTabel(JTable table1, String valueToSearch)
    {
        Connection con = koneksiDB.getConnection();
        PreparedStatement ps1;
        
        try {
            ps1 = con.prepareStatement("select * from volunteer where concat(id_volunteer,nama_volunteer,alamat_volunteer,email_volunteer,password_volunteer,foto_volunteer) like ?");
            ps1.setString(1, "%"+valueToSearch+"%");
            
            ResultSet rs = ps1.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table1.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[7];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                
                model.addRow(row);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getVolunteerTask(JTable table1, String valueToSearch)
    {
        Connection con = koneksiDB.getConnection();
        PreparedStatement ps1;
        
        try {
            ps1 = con.prepareStatement("select * from task where concat(id_task,id_operator,id_volunteer,deskripsi_task,status) like ?");
            ps1.setString(1, "%"+valueToSearch+"%");
            
            ResultSet rs = ps1.executeQuery();
            DefaultTableModel model = (DefaultTableModel)table1.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[5];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                
                
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

    void crudOperator(char c, String id_operator, String nama_operator, String email_operator, String alamat_operator, String divisi_operator, String ImgPath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void crudOperator(char c, String toString, Object object, Object object0, Object object1, Object object2, Object object3, Object object4, Object object5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
