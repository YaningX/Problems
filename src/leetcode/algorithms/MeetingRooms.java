package leetcode.algorithms;

import java.util.Arrays;
import java.util.Comparator;

import leetcode.util.Interval;

// https://leetcode.com/problems/meeting-rooms/
// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
// (si < ei), determine if a person could attend all meetings.
// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return false.
public class MeetingRooms {
  public boolean canAttendMeetings(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {
      @Override
      public int compare(Interval a, Interval b) {
        return a.start - b.start;
      }
    });
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start < intervals[i - 1].end) {
        return false;
      }
    }
    return true;
  }
}
