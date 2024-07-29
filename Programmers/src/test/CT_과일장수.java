package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CT_과일장수 {
    public int solution(int k, int m, int[] score) {
        List<Integer> scoreDesc = new ArrayList<>();
        int totalScore = 0;

        // 1. 상자 개수(N) 구하기 , score 내림차순
        int N = score.length / m;
        for (int i : score) {
            scoreDesc.add(i);
        }
        scoreDesc.sort(Comparator.reverseOrder());

        // 2. 상자 개수에 따른 답 구하기
        if (N == 1) {
            totalScore = m * scoreDesc.get(m-1);

        } else if (N > 1) {
            for (int i = 1; i <= N; i++) {
                totalScore += m * scoreDesc.get(m * i - 1);
            }

        }

        return totalScore;
    }

    public static void main(String[] args) {
        CT_과일장수 fruitSeller = new CT_과일장수();

        // 테스트 케이스 설정
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        // 솔루션 메서드 호출
        int result = fruitSeller.solution(k, m, score);

        // 결과 출력
        System.out.println("Total score: " + result);
    }
}
