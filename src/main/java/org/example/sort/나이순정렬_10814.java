package org.example.sort;

import java.io.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
여러 값을 하나로 묶어서 받아야 하는 경우 객체를 사용하는 것도 OK
int를 무조건 int로 받지 않아도 된다. String도 고려해 볼 것
 */
public class 나이순정렬_10814 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int age = Integer.parseInt(s[0]);
            String name = s[1];
            Member member = new Member(age, name, i);
            members.add(member);
        }

        members.sort(((o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.sequence-o2.sequence;
            }
            return Integer.compare(o1.age, o2.age);
        }));


        members.sort(Comparator.comparingInt(member -> member.age));


        for (int i = 0; i < N; i++) {
            bw.write(members.get(i).age + " " + members.get(i).name +"\n");
        }

        bw.flush();
        bw.close();
    }

    static class Member {
        int sequence;
        int age;
        String name;

        Member(int age, String name, int sequence) {
            this.age = age;
            this.name = name;
            this.sequence = sequence;
        }
    }
}
