/*
  This file is part of JOP, the Java Optimized Processor
    see <http://www.jopdesign.com/>

  Copyright (C) 2011, Benedikt Huber (benedikt@vmars.tuwien.ac.at)

  This program is free software: you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation, either version 3 of the License, or
  (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.jopdesign.common.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Purpose: Utilities to lift Collection functionality to Iterable s and Iterator s
 * @author Benedikt Huber (benedikt@vmars.tuwien.ac.at)
 *
 */
public class Iterators {

	/**
	 * Purpose: An empty iterator
	 */
	public static class EmptyIterator<T> implements Iterator<T> {

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public T next() {
			return null;
		}

		@Override
		public void remove() {
			throw new RuntimeException("remove called on invalid iterator");
		}
		
	}

	/**
	 * Purpose: Iterator for arrays
	 */
	public static class ArrayIterator<T> implements Iterator<T> {
		private int ix;
		private T[] arr;

		public ArrayIterator(T[] arr) {
			this.arr = arr;
			this.ix = 0;
		}

		@Override
		public boolean hasNext() {
			return ix<arr.length;
		}

		@Override
		public T next() {
			T r = arr[ix];
			ix++;
			return r;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("remove() not supported by ArrayIterator<T>");
		}
		
	}

	/**
	 * Purpose: Iterator for the elements of an iterator of iterators
	 */
	public static class ConcatIterator<T> implements Iterator<T> {

		private Iterator<? extends Iterable<T>> outerIterator;
		private Iterator<T> innerIterator;

		public ConcatIterator(Iterable<T>[] cs) {
			this.outerIterator = new ArrayIterator<Iterable<T>>(cs);
			this.innerIterator = new EmptyIterator<T>();
		}
		
		public ConcatIterator(Iterable<? extends Iterable<T>> cs) {
			this.outerIterator = cs.iterator();
			this.innerIterator = new EmptyIterator<T>();
		}

		@Override
		public boolean hasNext() {
			while(! innerIterator.hasNext()) {
				if(! outerIterator.hasNext()) return false;
				innerIterator = outerIterator.next().iterator();
			}
			return true;
		}
		
		@Override
		public T next() {
			if(! hasNext()) return null;
			return innerIterator.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("remove() not supported by ConcatIterator");
		}
		
	}

	public static<T, C extends Collection<T>> C addAll(C coll, Iterable<? extends T> addme) {
		
		for(T e : addme) { coll.add(e); }
		return coll;
	}

	public static<T> Iterable<T> concat(final Iterable<? extends Iterable<T>> cs) {

		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new ConcatIterator<T>(cs);
			}		
		};
	}

	public static<T> Iterable<T> concat(final Iterable<T> c1, final Iterable<T> c2) {

		ArrayList<Iterable<T>> listOfLists = new ArrayList<Iterable<T>>(2);
		listOfLists.add(c1);
		listOfLists.add(c2);
		return concat(listOfLists);
	}

	public static<T> Iterable<T> singleton(T elem) {

		return Collections.singleton(elem);
	}

	public static<T> int size(Iterable<T> nodes) {
		
		int i = 0;
		Iterator<T> iter = nodes.iterator();
		while(iter.hasNext()) {
			i++;
			iter.next();
		}
		return i;
	}

}
