package com.poly.websitesellphone.DAO;

import com.poly.websitesellphone.Service.AdressInterface;
import com.poly.websitesellphone.model.AdressModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdressDAO extends DataDAO implements AdressInterface {
    @Override
    public List<AdressModel> selectAll() {
        List<AdressModel> list = new ArrayList<>();
        try(Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(ADRESS_SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idAddress = rs.getInt("id_address");
                int idUser = rs.getInt("id_user");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String fullName = rs.getString("full_name");
                list.add(new AdressModel(idAddress, idUser, phone, address, fullName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public AdressModel selectById(int id) {
        AdressModel adressModel = null;
        try (Connection con = getConnection()){
            ResultSet rs = query(ADRESS_SELECT_BY_ID, id);
            while (rs.next()) {
                int idAddress = rs.getInt("id_address");
                int idUser = rs.getInt("id_user");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String fullName = rs.getString("full_name");
                adressModel = new AdressModel(idAddress, idUser, phone, address, fullName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adressModel;
    }

    @Override
    public List<AdressModel> selectByIdUser(int idUser) {
        List<AdressModel> list = new ArrayList<>();
        try(Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(ADRESS_SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idAddress = rs.getInt("id_address");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String fullName = rs.getString("full_name");
                list.add(new AdressModel(idAddress, idUser, phone, address, fullName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean insert(AdressModel adressModel) {
        boolean rs = false;
        try {
            Connection con = getConnection();
            update(ADRESS_INSERT,
                    adressModel.getIdUser(),
                    adressModel.getPhone(),
                    adressModel.getAdress(),
                    adressModel.getFullName()
            );
            rs = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    @Override
    public boolean update(AdressModel adressModel) {
        boolean rs = false;
        try {
            Connection con = getConnection();
            update(ADRESS_INSERT,
                    adressModel.getIdUser(),
                    adressModel.getPhone(),
                    adressModel.getAdress(),
                    adressModel.getFullName(),
                    adressModel.getIdAddress()
            );
            rs = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }

    @Override
    public boolean delete(AdressModel adressModel) {
        boolean rs = false;
        try {
            Connection con = getConnection();
            update(ADRESS_DELETE,
                    adressModel.getIdAddress()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
}
