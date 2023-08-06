/**
 * 
 */
package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DaoTrangs;

/**
 * @author DELL
 *
 */
@Repository
public interface IDaoTrangRespo extends JpaRepository<DaoTrangs, Integer> {

}
