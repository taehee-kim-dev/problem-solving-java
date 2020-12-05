package programmers.kakao.openchattingroom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        Map<String, User> users = new HashMap<>();
        List<String> answer = new ArrayList<>();
        List<Record> records = new ArrayList<>();

        for (String oneRecord : record) {
            String[] splitRecord = oneRecord.split(" ");
            String command = splitRecord[0];
            String userId = splitRecord[1];
            String nickname = "";

            if (splitRecord.length == 3) {
                nickname = splitRecord[2];
            }

            switch (command) {
                case "Enter":
                    if (!users.containsKey(userId)) {
                        User newUser = new User(nickname);
                        users.put(userId, newUser);
                        records.add(new Record(command, newUser));
                    } else {
                        User user = users.get(userId);
                        if (!user.getNickname().equals(nickname)) {
                            user.changeNickname(nickname);
                        }
                        records.add(new Record(command, user));
                    }
                    break;
                case "Leave":
                    records.add(new Record(command, users.get(userId)));
                    break;
                case "Change":
                    users.get(userId).changeNickname(nickname);
                    break;
            }
        }

        for (Record oneRecord : records) {
            answer.add(oneRecord.getRecord());
        }

        return answer.toArray(new String[0]);
    }
}

class Record {
    private final String status;
    private final User user;

    public Record(String status, User user) {
        this.status = status;
        this.user = user;
    }

    public String getRecord() {
        if (status.equals("Enter")) {
            return user.getNickname() + "님이 들어왔습니다.";
        }
        return user.getNickname() + "님이 나갔습니다.";
    }
}

class User {
    private String nickname;

    public User(String nickname) {
        this.nickname = nickname;
    }

    public void changeNickname(String newNickname) {
        this.nickname = newNickname;
    }

    public String getNickname() {
        return nickname;
    }
}

class Test {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
            "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(new Solution().solution(record)));
        // ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
    }
}
