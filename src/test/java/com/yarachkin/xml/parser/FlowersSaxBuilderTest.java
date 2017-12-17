package com.yarachkin.xml.parser;

import com.yarachkin.xml.entity.CutFlower;
import com.yarachkin.xml.entity.Flower;
import com.yarachkin.xml.entity.GardenFlower;
import com.yarachkin.xml.entity.GrowingTips;
import com.yarachkin.xml.entity.Multiplying;
import com.yarachkin.xml.entity.VisualParameters;
import com.yarachkin.xml.exception.XmlParserException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class FlowersSaxBuilderTest {
    private FlowersSaxBuilder builder;
    private List<Flower> flowers;

    @BeforeMethod
    public void setUp() throws IOException, XmlParserException {
        File testFile = File.createTempFile("test_sax_parser", "xml");
        testFile.deleteOnExit();
        String filePath = testFile.getAbsolutePath();

        String testText = "<flowers xmlns=\"http://www.dei.isep.ipp.pt/Flowers\">\n" +
                "    <cut-flower id=\"ID-1\" freshness=\"70\">\n" +
                "        <name>rose</name>\n" +
                "        <origin>Belarus</origin>\n" +
                "        <visual-parameters>\n" +
                "            <stem-color>green</stem-color>\n" +
                "            <leaf-color>white</leaf-color>\n" +
                "            <flower-height>30</flower-height>\n" +
                "        </visual-parameters>\n" +
                "        <multiplying>seed</multiplying>\n" +
                "    </cut-flower>\n" +
                "\n" +
                "    <garden-flower id=\"ID-2\" soil=\"unpaved\">\n" +
                "        <name>chrysanthemum</name>\n" +
                "        <origin>Germany</origin>\n" +
                "        <visual-parameters>\n" +
                "            <stem-color>green</stem-color>\n" +
                "            <leaf-color>pink</leaf-color>\n" +
                "            <flower-height>38</flower-height>\n" +
                "        </visual-parameters>\n" +
                "        <multiplying>stalk</multiplying>\n" +
                "        <growing-tips>\n" +
                "            <temperature>30</temperature>\n" +
                "            <lighting>true</lighting>\n" +
                "            <watering>300</watering>\n" +
                "        </growing-tips>\n" +
                "    </garden-flower>" +
                "</flowers>";

        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(testText);
        }

        builder = new FlowersSaxBuilder();
        builder.buildFlowers(filePath);

        flowers = new ArrayList<>();
        CutFlower cutFlower = new CutFlower("rose", "Belarus", new VisualParameters("green",
                "white", 30), Multiplying.SEED, "ID-1", 70);
        GardenFlower gardenFlower = new GardenFlower("chrysanthemum", "Germany", new VisualParameters("green",
                "pink", 38), Multiplying.STALK, "ID-2",
                new GrowingTips(30, true, 300), "unpaved");
        flowers.add(cutFlower);
        flowers.add(gardenFlower);
    }

    @Test
    public void buildFlowersTest() {
        assertEquals(builder.getFlowers(), flowers);
    }
}