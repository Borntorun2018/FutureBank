package com.eBusiness.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.collection.internal.PersistentSet;
import org.hibernate.criterion.DetachedCriteria;

public class HibernateUtils {

	
	
	
	/**
	 * This method sets the FetchMode to <i>JOIN</i> for each element name
	 * held in the passed ArrayList object. Used to override Hibernate lazy
	 * loading.
	 * 
	 * @param joinsList -
	 *            ListArray of element names to join
	 * @param dCriteria -
	 *            DetachedCriteria for class
	 * @return criteria
	 * 
	 * @see HibCrimeDAO - getSelectedCrimeSections
	 */
	public static DetachedCriteria joinElements(ArrayList joinsList,
			DetachedCriteria dCriteria) {
		for (Iterator iterator = joinsList.iterator(); iterator.hasNext();) {
			dCriteria.setFetchMode(iterator.next().toString(), FetchMode.JOIN);
		}
		return dCriteria;
	}

	/**
	 * This method iterates through all the methods of the passed object. When a
	 * getter is encountered, it is invoked and if the object is an instance of a
	 * Persistent Set it will check if it has been initialized. If it has not,
	 * then the object will be set to null.
	 * <br><br>
	 * This will prevent a lazily loaded (and uninitalized) Set being passed to
	 * a Jasper Report which would otherwise have thrown an error.
	 * 
	 * @param obj
	 * @return obj
	 * 
	 * @see HibCrimeDAO - getSelectedCrimeSections
	 */
	public static Object collectionToNull(Object obj) {
		Method[] methods = obj.getClass().getMethods();

		for (int i = 0; i < methods.length; i++) {
			Method m = methods[i];
			String methodName = m.getName();
			String[] empty = {};

			if (methodName.startsWith("get")) {
				try {
					Object o = m.invoke(obj, (Object [])empty);

					if (o instanceof PersistentSet) {
						if (!Hibernate.isInitialized(o)) {
							Class[] clazz = new Class[1];
							clazz[0] = Set.class;
							Object[] ojb = { null };
							Method setMethod = obj.getClass().getMethod(
									m.getName().replaceFirst("g", "s"), clazz);
							setMethod.invoke(obj, ojb);
						} 
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}

		return obj;
	}	
	
	
	
	
	
	
	
	
	
	
	
}
