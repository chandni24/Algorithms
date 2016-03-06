/*
 * Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*
* @author chandni
 */

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class InsertInterval {

	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	/*
	 * Does not work properly for merging cases
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		Interval changedInterval = null;
		for(Interval i:intervals) {
			if(newInterval.start >= i.start && newInterval.end <= i.end)
				return intervals;
			else if(newInterval.start <= i.end && newInterval.end >= i.end) {
				i.end = newInterval.end;
				changedInterval = i;
				break;
			}
			else if(newInterval.start <= i.start && newInterval.end >= i.start) {
				i.start = newInterval.start;
				changedInterval = i;
				break;
			}
		}
		for(Iterator<Interval> curr = intervals.iterator(); curr.hasNext();) {
			Interval i = curr.next();
			if(changedInterval.start < i.start && changedInterval.end > i.start && changedInterval != i) {
				changedInterval.end = i.end;
				curr.remove();
			}
		}

		for(Iterator<Interval> curr = intervals.iterator(); curr.hasNext();) {
			Interval i = curr.next();
			System.out.println(i.start+" "+i.end);
		}
		return intervals;
	}
	*/

    public List<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {
    	 
        List<Interval> result = new ArrayList<Interval>();
        Interval changedInterval = null;
        
        for(Interval i:intervals) {
        	//System.out.println(i.start+" "+i.end);
			if(i.end < newInterval.start) {
				result.add(i);
			}
			else if(i.start > newInterval.end) {
				result.add(newInterval);
				newInterval = i;
			}
			else if(i.end >= newInterval.start || i.start <= newInterval.end) {
				newInterval = new Interval(Math.min(newInterval.start, i.start), Math.max(newInterval.end, i.end));
			}
		}
        
        result.add(newInterval);
        //System.out.println();
		for(Iterator<Interval> curr = result.iterator(); curr.hasNext();) {
			Interval i = curr.next();
			System.out.println(i.start+" "+i.end);
		}
        return result;
    }
	public static void main(String[] args) {
		//[1,2],[3,5],[6,7],[8,10],[12,16]
		InsertInterval InsertInterval = new InsertInterval();
		ArrayList<Interval> li = new ArrayList<Interval>();
		li.add(InsertInterval.new Interval(1, 2));
		li.add(InsertInterval.new Interval(3, 5));
		li.add(InsertInterval.new Interval(6, 7));
		li.add(InsertInterval.new Interval(8, 10));
		li.add(InsertInterval.new Interval(12, 16));
		
		Interval newInt = InsertInterval.new Interval(4, 9);
		InsertInterval.insert2(li, newInt);
		
	}
}

