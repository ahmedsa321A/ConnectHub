/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Back_end;

import java.lang.reflect.Type;

/**
 *
 * @author ghane
 */
public interface LoadFromFile<T> {
    T loadFromFile(String filePath, Type typeOfT);
}
