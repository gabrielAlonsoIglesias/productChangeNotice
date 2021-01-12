
package com.poc.repository.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.poc.common.Constants;
import com.poc.entity.ChangeEventEntity;
import com.poc.entity.Observable;
import com.poc.exception.RepositoryException;
import com.poc.repository.ObservableRepository;

/**
 * @author
 */
@Repository("observableRepositoryImpl")
public class ObservableRepositoryImpl implements ObservableRepository {

	private static final Log LOG = LogFactory.getLog(ObservableRepositoryImpl.class);

	private static final String FILE = System.getProperty("user.dir") + "/src/main/resources/respository/EVENTS.txt";

	private static final String TMP_FILE = System.getProperty("user.dir") + "/src/main/resources/respository/EVENTS.txt";

	@Override
	public List<Observable> findAll() throws RepositoryException {
		List<Observable> observables = new ArrayList<>();

		try {

		} catch (Exception e) {
			throw new RepositoryException(e);
		}
		return observables;
	}

	@Override
	public void insert(Observable observable) throws RepositoryException {
		try {


//((		db.inventory.insertOne(
//{ item: "canvas", qty: 100, tags: ["cotton"], size: { h: 28, w: 35.5, uom: "cm" } }
//)
/*		
Document canvas = new Document("item", "canvas")
.append("qty", 100)
.append("tags", singletonList("cotton"));

Document size = new Document("h", 28)
.append("w", 35.5)
.append("uom", "cm");
canvas.put("size", size);

collection.insertOne(canvas);
*/
			
			
		} catch (Exception e) {
			throw new RepositoryException(e);
		}
	}

//	@Override
	public void delete(Observable observable) throws RepositoryException {
		try {

		} catch (Exception e) {
			throw new RepositoryException(e);
		}
	}

}
