import java.util.*;

class Solution {
    // 0. 노래 정보를 하나로 묶기 위한 클래스 (고유번호와 재생수)
    static class Music implements Comparable<Music> {
        int id;   // 고유 번호 (0, 1, 2...)
        int play; // 재생 횟수

        public Music(int id, int play) {
            this.id = id;
            this.play = play;
        }

        // 정렬 기준을 정의하는 메서드 (Java의 규칙)
        @Override
        public int compareTo(Music other) {
            // 재생 횟수가 같다면? 고유 번호가 낮은 순(오름차순)으로 정렬
            if (this.play == other.play) {
                return this.id - other.id;
            }
            // 기본적으로는 재생 횟수가 많은 순(내림차순)으로 정렬
            return other.play - this.play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생 횟수를 저장하는 장부 (장르 우선순위용)
        // 예: {"classic": 1450, "pop": 3100}
        HashMap<String, Integer> genrePlayMap = new HashMap<>();
        
        // 2. 장르별로 속한 노래 객체들을 리스트로 모으는 장부
        // 예: {"classic": [Music(0, 500), Music(2, 150), ...]}
        HashMap<String, List<Music>> albumMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            // 장르별 총합 누적 (앞서 배운 getOrDefault 활용!)
            genrePlayMap.put(genres[i], genrePlayMap.getOrDefault(genres[i], 0) + plays[i]);
            
            // 장르별 리스트에 노래 추가 (없으면 새 리스트 생성 후 추가)
            albumMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Music(i, plays[i]));
        }

        // 3. 장르 정렬하기 (총 재생수가 많은 장르가 0번 인덱스로 오게 함)
        List<String> sortedGenres = new ArrayList<>(genrePlayMap.keySet());
        sortedGenres.sort((g1, g2) -> genrePlayMap.get(g2) - genrePlayMap.get(g1));

        // 최종 수록될 노래 번호를 담을 임시 리스트
        List<Integer> resultList = new ArrayList<>();

        // 4. 인기 장르 순서대로 순회하며 노래 뽑기
        for (String genre : sortedGenres) {
            List<Music> songs = albumMap.get(genre);
            
            // 장르 내 노래들을 재생수/번호 기준에 맞춰 정렬 (Music 클래스의 compareTo 사용)
            Collections.sort(songs);

            // 각 장르당 최대 2곡까지만 담기
            // Math.min을 쓰는 이유는 장르에 노래가 1곡만 있을 수도 있기 때문입니다.
            int limit = Math.min(songs.size(), 2);
            for (int i = 0; i < limit; i++) {
                resultList.add(songs.get(i).id);
            }
        }

        // 5. 결과 리스트(Integer)를 문제 요구사항인 int[] 배열로 변환
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}