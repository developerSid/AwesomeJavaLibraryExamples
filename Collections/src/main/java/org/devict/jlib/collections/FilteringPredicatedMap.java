package org.devict.jlib.collections;

import org.apache.commons.collections4.map.AbstractMapDecorator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by Gary.Myers on 10/5/2016.
 */
public class FilteringPredicatedMap<K, V> extends AbstractMapDecorator<K, V>
{
   private static final Predicate<?> NULL_PREDICATE = (i -> i != null);
   private final Predicate<K> keyPredicate;
   private final Predicate<V> valuePredicate;
   private final transient Map<K, V> map;

   @SuppressWarnings("unchecked")
   public static <T> T nullPredicateInstance()
   {
      return (T) NULL_PREDICATE;
   }

   /**
    * Constructor that creates a {@link HashMap} that throws out null keys and values
    */
   public FilteringPredicatedMap()
   {
      this(new HashMap<>(), nullPredicateInstance(), nullPredicateInstance());
   }
   /**
    * Constructor that wraps (not copies).
    *
    * @param map  the map to decorate, must not be null
    * @param keyPredicate  the predicate to validate the keys, null means no check
    * @param valuePredicate  the predicate to validate to values, null means no check
    * @throws NullPointerException if the map is null
    */
   public FilteringPredicatedMap(Map<K, V> map, Predicate<K> keyPredicate, Predicate<V> valuePredicate)
   {
      super(map);
      this.map = map;
      this.keyPredicate = keyPredicate;
      this.valuePredicate = valuePredicate;
   }

   protected boolean checkKeyValue(K key)
   {
      return keyPredicate != null && keyPredicate.test(key);
   }

   protected boolean checkSetValue(V value)
   {
      return valuePredicate != null && valuePredicate.test(value);
   }

   @Override
   public V put(final K key, final V value)
   {
      if(checkKeyValue(key) && checkSetValue(value))
      {
         return super.put(key, value);
      }
      else
      {
         return value;
      }
   }

   @Override
   public void putAll(final Map<? extends K, ? extends V> mapToCopy)
   {
      mapToCopy.entrySet().stream()
         .filter(i -> checkKeyValue(i.getKey()) && checkSetValue(i.getValue()))
         .forEach(i -> put(i.getKey(), i.getValue()));
   }
}
