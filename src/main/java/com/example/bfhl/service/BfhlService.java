package com.example.bfhl.service;

import com.example.bfhl.dto.BfhlResponse;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BfhlService {

    public BfhlResponse processData(List<String> data) {
        BfhlResponse response = new BfhlResponse();
        
        
        response.setIs_success(true);
        response.setUser_id("soumen_samanta_12072003");
        response.setEmail("samantasoumen8978@gmail.com");
        response.setRoll_number("2211981398");

        
        List<String> evenNumbers = new ArrayList<>();
        List<String> oddNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        
        int sum = 0;
        List<String> alphabeticalChars = new ArrayList<>();

        
        for (String item : data) {
            if (item == null || item.isEmpty()) continue;
            
            
            if (isNumeric(item)) {
                int num = Integer.parseInt(item);
                sum += num;
                
                if (num % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }
            }
            
            else if (item.matches("[a-zA-Z]+")) {
                alphabets.add(item.toUpperCase());
                alphabeticalChars.add(item);
            }
            
            else {
                specialCharacters.add(item);
            }
        }

        
        response.setOdd_numbers(oddNumbers);
        response.setEven_numbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(specialCharacters);
        
        response.setSum(String.valueOf(sum));
        
      
        String concatString = createAlternatingCapsString(alphabeticalChars);
        response.setConcat_string(concatString);

        return response;
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String createAlternatingCapsString(List<String> alphabeticalChars) {
        Collections.reverse(alphabeticalChars);
        String combined = String.join("", alphabeticalChars);
        
        StringBuilder result = new StringBuilder();
        boolean upperCase = true;
        
        for (char c : combined.toCharArray()) {
            if (Character.isLetter(c)) {
                if (upperCase) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(Character.toLowerCase(c));
                }
                upperCase = !upperCase;
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}