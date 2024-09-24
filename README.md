# Media Rental Simulator

## Pontifícia Universidade Católica do Rio Grande do Sul
### Prof. Marcelo H. Yamaguti
### 2024/1

## Overview
ACMEMidia is a company that rents media (videos and music) and requires an application to process data related to its media. This project aims to develop the application to meet the company's needs as outlined in the exercise description.

## Features
- **Media Registration**: 
  - Register videos and music while ensuring unique codes.
- **Data Retrieval**:
  - Retrieve media data by code, category, and quality.
  - Find the music with the longest duration.
  - Remove media entries by code.
  - Calculate total rental values for all media.
  
## Functionality
1. **Register Videos**: Input details for each video. If the code is duplicated, an error message will be shown.
2. **Register Music**: Input details for each music. Duplicates will trigger an error message.
3. **Display Media Details**: 
   - By media code
   - By category
   - By video quality
4. **Remove Media**: Remove entries by media code.
5. **Calculate Rentals**: Compute the total rental values for all media.

## Data Processing
- Input will be read from a text file (`entrada.txt`), and output will be written to (`saida.txt`).
- Each section of the input file will specify the required data until a termination signal (-1) is encountered.

### Input Format
- **Videos**: Each line includes code, title, year, category, and quality.
- **Music**: Each line includes code, title, year, category, and duration.
- Additional lines will provide data for queries and removals.

## Requirements
- Java Development Kit (JDK)
- Text editor or IDE (e.g., Eclipse, IntelliJ IDEA)

## Getting Started
1. Clone the repository:
   ```bash
   git clone https://github.com/luanpaacheco/Media-Rental-Simulator.git
