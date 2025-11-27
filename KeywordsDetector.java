public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the keywords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        // Iterate over each sentence in the array
        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            
            // Convert the sentence to lowercase for comparison purposes
            // (Note: We use standard Java method here for safety, but you could also use MyString.lowerCase)
            String lowerSentence = sentence.toLowerCase();
            
            boolean found = false;
            
            // Iterate over each keyword to check if it exists in the sentence
            for (int j = 0; j < keywords.length; j++) {
                String keyword = keywords[j];
                String lowerKeyword = keyword.toLowerCase();
                
                // Check if the sentence contains the keyword
                if (lowerSentence.contains(lowerKeyword)) {
                    found = true;
                    break; // Stop checking keywords for this sentence once one is found
                }
            }
            
            // If a keyword was found, print the ORIGINAL sentence
            if (found) {
                System.out.println(sentence);
            }
        }
    }
}