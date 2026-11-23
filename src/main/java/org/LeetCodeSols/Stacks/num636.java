package org.LeetCodeSols.Stacks;

import java.util.List;
import java.util.Stack;

/***
 * result accumulates the exclusive running time for every function id, stack holds the ids of functions currently running with the most recently started one on top, and prevTime remembers the timestamp right after whichever interval was last charged
 * every log line is split into id, type and timestamp, since each one marks either a function starting or finishing at that exact moment
 * when a start log comes in and some other function is already on the stack, that caller was running the whole stretch between prevTime and timestamp, so that stretch gets added to its total before the new call takes over
 * the new id is then pushed on top of the stack and prevTime jumps to timestamp, since the newly started function's own clock begins counting from right here
 * when an end log comes in, the id on top of the stack is popped off, since start and end logs are always properly nested, and that function gets charged timestamp - prevTime + 1 to cover the inclusive final unit of time it was running
 * prevTime then moves to timestamp + 1, so whichever function resumes next, now back on top of the stack, only gets charged for time starting after this one finished
 * once every log has been processed this way, result holds the exclusive time each function spent running on its own
 */

public class num636 {
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += timestamp - prevTime;
                }
                stack.push(id);
                prevTime = timestamp;
            } else {
                result[stack.pop()] += timestamp - prevTime + 1;
                prevTime = timestamp + 1;
            }
        }

        return result;
    }
}
