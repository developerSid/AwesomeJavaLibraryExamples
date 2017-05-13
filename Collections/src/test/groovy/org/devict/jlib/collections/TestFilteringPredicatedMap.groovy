package org.devict.jlib.collections

import spock.lang.Specification

/**
 * Created by developerSid on 10/6/2016.
 */
class TestFilteringPredicatedMap extends Specification
{
   def 'test default constructor add single good value' ()
   {
      setup:
         Map<String, String> map = new FilteringPredicatedMap<>()
      when:
         map.put('one', 'a')
      then:
         map == ['one' : 'a']
   }

   def 'test default constructor add single good value and single bad value' ()
   {
      setup:
         Map<String, String> map = new FilteringPredicatedMap<>()
      when:
         map.put('one', 'a')
         map.put('two', null)
      then:
         map == ['one' : 'a']
   }

   def 'test default constructor add single good key and single bad key' ()
   {
      setup:
         Map<String, String> map = new FilteringPredicatedMap<>()
      when:
         map.put('one', 'a')
         map.put(null, 'b')
      then:
         map == ['one' : 'a']
   }

   def 'test default constructor add multiple good and bad key/value combinations' ()
   {
      def realNull = null

      setup:
         Map<String, String> map = new FilteringPredicatedMap<>()
         def allMap = [
            'one': 'a',
            'two': 'b',
            'four': null,
            'five': 'f'
         ]
         allMap.put(null, 'c')
      when:
         map.putAll(allMap)
      then:
         map == [
            'one': 'a',
            'two': 'b',
            'five': 'f'
         ]
   }
}
