package com.testRestWebService.testrestfulwebservice.repositories;

import com.testRestWebService.testrestfulwebservice.domain.ProductPage;
import com.testRestWebService.testrestfulwebservice.repositories.pageRepository.ProductPageRepository;
import com.testRestWebService.testrestfulwebservice.service.parserServices.ProductPageRequestParserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    ProductPageRepository productPageRepository;

    @Autowired
    ProductPageRequestParserService productPageRequestParserService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() throws Exception {
        ProductPage productPage=productPageRequestParserService.parseProductRequest("https://www.trendyol.com/avva/erkek-beyaz-polo-yaka-duz-t-shirt-a01b1175-p-42427628?boutiqueId=512009&merchantId=107671");

        productPageRepository.save(productPage);
        Optional<ProductPage> uomOptional = productPageRepository.findByWebURL("https://www.trendyol.com/avva/erkek-beyaz-polo-yaka-duz-t-shirt-a01b1175-p-42427628?boutiqueId=512009&merchantId=107671");

        assertEquals("erkek-beyaz-polo-yaka-duz-t-shirt-a01b1175", uomOptional.get().getProductName());
    }


}
