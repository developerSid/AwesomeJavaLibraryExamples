package org.devict.jlib.beanutils;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean2;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by developerSid on 5/12/17.
 *
 * Demonstrates using BeanUtils
 */
public class CopyFromDifferentObjects
{
   public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
      BeanUtilsBean utilsBean = BeanUtilsBean2.getInstance();
      utilsBean.getConvertUtils().register(false, false, 0);
      BeanOne one = new BeanOne();

      one.setPropertyOne("One");
      one.setPropertyTwo("Two");
      one.setPropertyThree(3L);
      one.setPropertyFour(4);  //this is a string in BeanTwo

      BeanTwo two = new BeanTwo();

      utilsBean.copyProperties(two, one);

      BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);

      System.out.println(two);
   }
}
