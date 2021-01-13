
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
import com.poc.exception.RepositoryException;
import com.poc.repository.ChangeEventRepository;

/**
 * @author galonsoi
 */
@Repository("changeEventRepositoryImpl")
public class ChangeEventRepositoryImpl implements ChangeEventRepository {

	private static final Log LOG = LogFactory.getLog(ChangeEventRepositoryImpl.class);

	private static final String FILE = System.getProperty("user.dir") + "/src/main/resources/respository/EVENTS.txt";

	private static final String TMP_FILE = System.getProperty("user.dir") + "/src/main/resources/respository/EVENTS.txt";

	@Override
	public List<ChangeEventEntity> getChangeEvents(Integer customerId) throws RepositoryException {

		List<ChangeEventEntity> changeEvents = new ArrayList<>();

		try {
			List<String> lines = Files.readAllLines(Paths.get(FILE));
			
			for (String line : lines) {

				LOG.info("scanProduct # line: " + line);

				if (!StringUtils.isEmpty(line)) {

					String values[] = line.split(Constants.HASH);

					Integer lCustomerId = Integer.parseInt(values[0]);
					String changeDescription = values[1];

					if (lCustomerId.equals(customerId)) {
						changeEvents.add(new ChangeEventEntity(lCustomerId, changeDescription));	
					}
				}
			}
		} catch (IOException e) {
			throw new RepositoryException(e);
		}
		return changeEvents;
	}
	
	@Override
	public void insert(ChangeEventEntity changeEventEntity) throws RepositoryException {
		try {
			Files.write(Paths.get(FILE),
						(changeEventEntity.toString() + System.lineSeparator()).getBytes(),
						StandardOpenOption.CREATE,
						StandardOpenOption.APPEND);					
		} catch (IOException e) {
			throw new RepositoryException(e);
		}
	}

	@Override
	public void delete(ChangeEventEntity changeEventEntity) throws RepositoryException {
		try {
			List<String> filtered = Files.lines(Paths.get(FILE)).filter(x -> !x.contains(changeEventEntity.toString())).collect(Collectors.toList());
		
			Files.write(Paths.get(TMP_FILE), filtered);		
			Files.copy(Paths.get(TMP_FILE), Paths.get(FILE), StandardCopyOption.REPLACE_EXISTING);
			Files.delete(Paths.get(TMP_FILE));
		} catch (IOException e) {
			throw new RepositoryException(e);
		}
	}

}
