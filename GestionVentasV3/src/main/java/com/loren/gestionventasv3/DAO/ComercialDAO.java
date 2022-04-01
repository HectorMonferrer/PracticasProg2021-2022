package com.loren.gestionventasv3.DAO;

import com.loren.gestionventasv3.POJO.Comercial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComercialDAO implements IOperationsCRUD<Comercial> {

    private Connection conn = ConexionBD.getConnection();

    public List<Comercial> getAll() {

        List<Comercial> lista = new ArrayList<Comercial>();
        try {
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM comercial";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Long idAux = rs.getLong("id");
                String nomAux = rs.getString("nombre");
                String ape1Aux = rs.getString("apellido1");
                String ape2Aux = rs.getString("apellido2");
                Float comAux = rs.getFloat("comision");

                Comercial a = new Comercial(idAux, nomAux, ape1Aux, ape2Aux, comAux);
                lista.add(a);
            }

            rs.close();
            st.close();

            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Comercial findById(Comercial object) {
        String sql = "SELECT * FROM comercial WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, object.getId());
            ResultSet rs = ps.executeQuery();
            Comercial a = null;
            while (rs.next()) {
                Long idAux = rs.getLong("id");
                String nomAux = rs.getString("nombre");
                String ape1Aux = rs.getString("apellido1");
                String ape2Aux = rs.getString("apellido2");
                Float comAux = rs.getFloat("comision");

                a = new Comercial(idAux, nomAux, ape1Aux, ape2Aux, comAux);
            }

            rs.close();
            ps.close();
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Comercial> findByNombre(Comercial object) {
        String sql = "SELECT * FROM comercial WHERE nombre = ?";
        List<Comercial> lista = new ArrayList<Comercial>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getNombre());
            ResultSet rs = ps.executeQuery();
            Comercial a = null;
            while (rs.next()) {
                Long idAux = rs.getLong("id");
                String nomAux = rs.getString("nombre");
                String ape1Aux = rs.getString("apellido1");
                String ape2Aux = rs.getString("apellido2");
                Float comAux = rs.getFloat("comision");

                a = new Comercial(idAux, nomAux, ape1Aux, ape2Aux, comAux);
                lista.add(a);
            }
            rs.close();
            ps.close();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Comercial> findByApellido(Comercial object) {
        String sql = "SELECT * FROM comercial WHERE apellido1 LIKE ?";
        List<Comercial> lista = new ArrayList<Comercial>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + object.getApellido1() + "%");
            ResultSet rs = ps.executeQuery();
            Comercial a = null;
            while (rs.next()) {
                Long idAux = rs.getLong("id");
                String nomAux = rs.getString("nombre");
                String ape1Aux = rs.getString("apellido1");
                String ape2Aux = rs.getString("apellido2");
                Float comAux = rs.getFloat("comision");
             
                a = new Comercial(idAux, nomAux, ape1Aux, ape2Aux, comAux);
                lista.add(a);
            }
            rs.close();
            ps.close();
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int add(Comercial object) {
        String sql = "INSERT INTO comercial(nombre, apellido1, apellido2, comision) VALUES (?,?,?,?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getNombre());
            ps.setString(2, object.getApellido1());
            ps.setString(3, object.getApellido2());
            ps.setFloat(4, object.getComision());
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(Comercial object) {
        String sql = "UPDATE comercial SET nombre=?, apellido1=?, apellido2=?, "
                + "comision=? WHERE id=?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getNombre());
            ps.setString(2, object.getApellido1());
            ps.setString(3, object.getApellido2());
            ps.setFloat(4, object.getComision());
            ps.setLong(6, object.getId());
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Comercial object) {
        String sql = "DELETE FROM comercial WHERE id=?;";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, object.getId());
            int i = ps.executeUpdate();
            ps.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
