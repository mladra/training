package interview.sii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

class InterviewTasksTest {

    final InterviewItem[] interviewItemsArray = new InterviewItem[]{
            new InterviewItem("Abc ?", "Xyz"),
            new InterviewItem("Abc ?", "Good"),
            new InterviewItem("Abc ??", "Maybe C?"),
            new InterviewItem("Abc ?", null),
            new InterviewItem("Is this real?", "Maybe Yes"),
            new InterviewItem("Is this real?", "Maybe No"),
            new InterviewItem("Is this? real?", "Maybe No"),
    };

    @Test
    void task1() {
        /* TODO create a list containing all InterviewItem objects from the interviewItemsArray, for which:
            - the answer property contains 'y' character
            - the question property ends with a single '?' character and only single character
        */

        List<InterviewItem> result = Arrays.stream(interviewItemsArray)
                .filter(item -> Objects.nonNull(item.getAnswer()))
                .filter(item -> item.getAnswer().contains("y"))
                .filter(item -> item.getQuestion().endsWith("?") && !item.getQuestion().endsWith("??"))
                .toList();

        Assertions.assertEquals(4, result.size());
    }

    @Test
    void task2_1() {
        /* TODO from the interviewItemsArray create a map {key: question, answers: [answer1, answer2]}:
            - questions should be unique
            - answers to the questions should be unique
        */

        Map<String, Set<String>> result = Arrays.stream(interviewItemsArray).collect(Collectors.groupingBy(InterviewItem::getQuestion))
                .entrySet().stream().map(entry -> {
                    Set<String> answers = entry.getValue().stream().map(InterviewItem::getAnswer).collect(Collectors.toSet());
                    return Map.entry(entry.getKey(), answers);
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Assertions.assertEquals(4, result.size());
        Assertions.assertEquals(3, result.get("Abc ?").size());
        Assertions.assertEquals(1, result.get("Abc ??").size());
        Assertions.assertEquals(2, result.get("Is this real?").size());
        Assertions.assertEquals(1, result.get("Is this? real?").size());
    }

    @Test
    void task2_2() {
        /* TODO from the interviewItemsArray create a map {key: question, answers: [answer1, answer2]}:
            - questions should be unique
            - answers to the questions should be unique
        */

        Map<String, Set<String>> result = Arrays.stream(interviewItemsArray)
                .collect(Collectors.groupingBy(InterviewItem::getQuestion, Collectors.mapping(InterviewItem::getAnswer, Collectors.toSet())));

        Assertions.assertEquals(4, result.size());
        Assertions.assertEquals(3, result.get("Abc ?").size());
        Assertions.assertEquals(1, result.get("Abc ??").size());
        Assertions.assertEquals(2, result.get("Is this real?").size());
        Assertions.assertEquals(1, result.get("Is this? real?").size());
    }

    private static class InterviewItem {

        private final String question;
        private final String answer;

        private InterviewItem(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }
    }

}
