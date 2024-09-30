package com.docanalyzer.project.service;

import java.util.List;

public interface GeminiService {
    public List<String> getSynonymsForLongestWord(Long documentId) throws Throwable;

}
