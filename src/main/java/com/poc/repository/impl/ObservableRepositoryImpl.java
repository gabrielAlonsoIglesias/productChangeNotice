
package com.poc.repository.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.poc.common.Constants;
import com.poc.entity.ChangeEventEntity;
import com.poc.entity.ObservableEntity;
import com.poc.exception.RepositoryException;
import com.poc.repository.ObservableRepository;

/**
 * @author galonsoi
 */
/*
@Repository("observableRepositoryImpl")
public class ObservableRepositoryImpl implements ObservableRepository {

	private static final Log LOG = LogFactory.getLog(ObservableRepositoryImpl.class);

	private static final String FILE = System.getProperty("user.dir") + "/src/main/resources/respository/EVENTS.txt";

	private static final String TMP_FILE = System.getProperty("user.dir") + "/src/main/resources/respository/EVENTS.txt";

	@Override
	public List<ObservableEntity> findAll() throws RepositoryException {
		List<ObservableEntity> observables = new ArrayList<>();

		try {

		} catch (Exception e) {
			throw new RepositoryException(e);
		}
		return observables;
	}

	@Override
	public void insert(ObservableEntity observable) throws RepositoryException {
		try {



			
			
		} catch (Exception e) {
			throw new RepositoryException(e);
		}
	}


	@Override
	public <S extends ObservableEntity> List<S> saveAll(Iterable<S> entites) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ObservableEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ObservableEntity> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ObservableEntity> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ObservableEntity> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ObservableEntity> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ObservableEntity> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ObservableEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ObservableEntity> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ObservableEntity> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<ObservableEntity> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ObservableEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends ObservableEntity> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends ObservableEntity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ObservableEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ObservableEntity> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends ObservableEntity> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}


//	@Override
	public void delete(ObservableEntity observable) throws RepositoryException {
		try {

		} catch (Exception e) {
			throw new RepositoryException(e);
		}
	}


}
*/
