package com.example.lastmodifiedproblem;

import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;
import org.springframework.stereotype.Component;

@Component("luceneTobaccoAnalysisConfigurer")
public class TextLuceneAnalysisConfigurer implements LuceneAnalysisConfigurer {
    @Override
    public void configure(LuceneAnalysisConfigurationContext context) {
        context.analyzer("name").custom()
            .tokenizer("standard")
            .tokenFilter("lowercase")
            .tokenFilter("asciiFolding");

        context.analyzer("name_prefix").custom()
            .tokenizer("standard")
            .tokenFilter("lowercase")
            .tokenFilter("asciiFolding")
            .tokenFilter("edgeNGram")
            // Handling prefixes from 2 to 7 characters.
            // Prefixes of 1 character or more than 7 will
            // not be matched.
            // You can extend the range, but this will take more
            // space in the index for little gain.
            .param("minGramSize", "2")
            .param("maxGramSize", "7");
    }
}
