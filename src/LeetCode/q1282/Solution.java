package LeetCode.q1282;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<GroupSizeAndPersonIndex> groupSizeAndPersonIndices = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            groupSizeAndPersonIndices.add(new GroupSizeAndPersonIndex(i, groupSizes[i]));
        }
        groupSizeAndPersonIndices
            .sort((a, b) -> -Integer.compare(a.getGroupSize(), b.getGroupSize()));

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (GroupSizeAndPersonIndex groupSizeAndPersonIndex : groupSizeAndPersonIndices) {
            temp.add(groupSizeAndPersonIndex.getPersonIndex());
            if (temp.size() == groupSizeAndPersonIndex.getGroupSize()) {
                answer.add(temp);
                temp = new ArrayList<>();
            }
        }
        return answer;
    }
}

class GroupSizeAndPersonIndex {
    private final int personIndex;
    private final int groupSize;

    public GroupSizeAndPersonIndex(int personIndex, int groupSize) {
        this.personIndex = personIndex;
        this.groupSize = groupSize;
    }

    public int getPersonIndex() {
        return personIndex;
    }

    public int getGroupSize() {
        return groupSize;
    }
}